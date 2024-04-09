# DEZSYS_GK_WAREHOUSE_DOM

## Aufgabenstellung
Die detaillierte [Aufgabenstellung](TASK.md) beschreibt die notwendigen Schritte zur Realisierung.

## Implementierung

1. Erstellen eines neuen Models (WarehouseData)
2. Anpassung des Java Codes (Application)
3. Zum Testen erstellung & speichern von WarehouseData Objekten
4. Finden von WarehouseData Objekten
5. Erstellung von Kronjobs für die automatische Speicherung von WarehouseData Objekten
6. Hinzufügen von Timestamps zu WarehouseData und ProductData mit LocalDateTime
7. Queries bearbeiten, damit sie auch den Timestamp und die mehreren Warehouses mit derselben ID berücksichtigen

## Fragen

### GKü

+ Nennen Sie 4 Vorteile eines NoSQL Repository im Gegensatz zu einem relationalen DBMS

- Skalierbarkeit: Horizontal skalierbar, ideal für Big Data.
- Flexibles Schema: Ermöglicht unstrukturierte Daten, schnelle Iterationen.
- Leistung: Optimiert für schnelle Lese- und Schreibvorgänge.
- Verfügbarkeit: Entworfen für hohe Verfügbarkeit über verteilte Systeme.

+ Nennen Sie 4 Nachteile eines NoSQL Repository im Gegensatz zu einem relationalen DBMS

- Standardisierung: Fehlt, was Lernkurve erhöht.
- Transaktionen: Eingeschränkte ACID-Transaktionsunterstützung.
- Konsistenz: Eventual Consistency kann zu Inkonsistenzen führen.
- Analysefähigkeit: Weniger robuste Abfrage- und Berichtsfunktionen.

+ Welche Schwierigkeiten ergeben sich bei der Zusammenführung der Daten?

Unterschiede in Datenmodellen, Konsistenz und Skalierungsstrategien erschweren die Integration.

+ Welche Arten von NoSQL Datenbanken gibt es?
+ Nennen Sie einen Vertreter für jede Art?

- Dokument: MongoDB
- Schlüssel-Wert: Redis
- Spaltenorientiert: Cassandra
- Graph: Neo4j

+ Beschreiben Sie die Abkürzungen CA, CP und AP in Bezug auf das CAP Theorem

- CA: Konsistenz und Verfügbarkeit, schwierig bei Netzwerkpartition.
- CP: Konsistenz und Partitionstoleranz, kann Verfügbarkeit beeinträchtigen.
- AP: Verfügbarkeit und Partitionstoleranz, kann Konsistenz beeinträchtigen.

+ Mit welchem Befehl koennen Sie den Lagerstand eines Produktes aller Lagerstandorte anzeigen.

Aller Lagerstandorte:
```sql
db.warehouses.aggregate([
  {$unwind: "$products"}, 
  {$match: {"products.productId": "X"}}, 
  {$group: {_id: null, totalQuantity: {$sum: "$products.quantity"}}} 
])
```

+ Mit welchem Befehl koennen Sie den Lagerstand eines Produktes eines bestimmten Lagerstandortes anzeigen.

Eines bestimmten Lagerstandortes:
```sql
db.warehouses.find(
  {"warehouseId": "Y", "products.productId": "X"},
  {"products.$": 1} 
)
```

### GKv

+ Formulierung 3 sinnvollen Fragestellung für einen Anwendungsfall in der Zentrale und deren Abfragen in einer Mongo Shell

1. Produkte mit geringem Bestand

Anwendungsfall: Identifizierung fast ausverkaufter Produkte.

MongoDB-Abfrage:
```sql
db.warehouseData.find({"productData.productQuantity": {$lt: 100}})
```

2. Lagerbestand eines spezifischen Produkts

Anwendungsfall: Finden aller Lager mit Vorräten von "Ariel Waschmittel Color".

MongoDB-Abfrage:
```sql
db.warehouseData.find({"productData.productName": "Ariel Waschmittel Color"})
```

3. Gesamtbestand eines Produkts

Anwendungsfall: Ermittlung der Gesamtzahl eines Produkts über alle Lager.

MongoDB-Abfrage:
```sql
db.warehouseData.aggregate([
  {$unwind: "$productData"},
  {$match: {"productData.productName": "Bio Orangensaft Sonne"}},
  {$group: {_id: null, total: {$sum: "$productData.productQuantity"}}}
])
```

### EKü

Erstellen eines Cronjob auf Windwos:

warehouse.bat:
```bat
cd Path\To\Application
gradle bootRun
```

Aufgabe im Task Scheduler erstellen

oder

Tool schtasks in Powerschell
```bat
schtasks /create /tn "Task" /tr "C:\Path\To\Application" /sc daily /st 14:00
```

## Quellen

* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [MongoDB Installation](https://docs.mongodb.com/manual/administration/install-community/)
* [mongo Shell Quick Reference](https://docs.mongodb.com/manual/reference/mongo-shell/)
* [mongo Shell Query Reference](https://www.mongodb.com/docs/manual/tutorial/query-embedded-documents/)
* [Grundlagen Spring Framework](https://spring.io/)
* [Spring Boot](https://spring.io/guides/gs/spring-boot/)
* [Spring Data MongoDB](https://spring.io/projects/spring-data-mongodb)
* [Spring RESTful Web Service](https://spring.io/guides/gs/rest-service/#use-maven)
* NoSQL Introduction
    - [NoSQL on w3resource](https://www.w3resource.com/mongodb/nosql.php)
    - [Introduction to NoSQL Database](https://www.edureka.co/blog/introduction-to-nosql-database/)
    - [NoSQL im Überblick](https://www.heise.de/ct/artikel/NoSQL-im-Ueberblick-1012483.html)
    - [Introduction to NoSQL Databases on YouTube ](https://www.youtube.com/watch?v=2yQ9TGFpDuM)
