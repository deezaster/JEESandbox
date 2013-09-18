JEESandbox
==========

Projektbeschreibung
-------------------
Es handelt sich hierbei um ein **Java EE Testprojekt** für 

- **Glassfish 4** 
- mit **Vaadin7** als GUI-Komponente, 
- **Eclipselink** als JPA Persistenzprovider, 
- **MySQL** als Datenbank 
- und mit **JUnit** Tests. 

Der Code habe ich mit Hilfe der IDE 'Eclipse Juno' auf einem MacBook Pro erstellt. 

Zweck
-----
Dieses Projekt entstand während meinem Selbststudium und wird auch weiterhin dafür verwendet. Niemals werde ich eine Garantie zur Vollständigkeit oder Lauffähigkeit geben. Auch wird von mir keinen Support geleistet. 

**JEESandbox steht jedem interessierten Java EE Neuling zur freien verfügung.** 

Literatur
---------
Der Code ist eine Zusammenfassung aus diversen Tutorials. Folgende Links haben mir sehr geholfen:

- **Oracle Java EE 7 Documentation**: http://docs.oracle.com/javaee/
- **An Eclipse / GlassFish / Java EE 6 Tutorial**: http://programming.manessinger.com/tutorials/an-eclipse-glassfish-java-ee-6-tutorial/
- **Effective pattern for data access with JPA**: http://workingonbits.com/2011/05/05/effective-pattern-for-data-access-with-jpa/
- **EJB FAQ**: https://glassfish.java.net/javaee5/ejb/EJB_FAQ.html
- **Vaadin** Homepage: https://vaadin.com

Empfehlen kann ich folgende Bücher:

- **EJB 3 Developer Guide** (ISBN 978-1-847195-60-9)
- **Mastering EnterpriseJavaBeans™ 3.0** (ISBN 978-0-471-78541-5)
- **Pro JPA 2: Mastering the Java™Persistence API** (ISBN 978-1-4302-1956-9)
- **Book of Vaadin**




Tips & Tricks
=============

Bean testen
-----------

###Als Webservice

Der schnellste und einfachste Weg ein Bean zu testen, ist dieses Bean als Webservice - mit der Annotation **@WebService** - zu deklarieren:

**Beispiel:** EJBProject\OrderManagerBean.java

```java
@Stateless
@LocalBean
@WebService
public class OrderManagerBean implements OrderManager {

	private static final long serialVersionUID = 1L;

	@EJB
	OrderService srvc;

	public OrderManagerBean() {
	}

	@Override
	public Long countOrders() {

		return srvc.countOrders();
	}
}
```

Der eigentliche Test erfolgt dann entweder mit dem **Webservice-Tester von Glassfish 4** ([Anleitung](http://programming.manessinger.com/tutorials/an-eclipse-glassfish-java-ee-6-tutorial/#heading_toc_j_22)) oder mit dem Tool **"soapUI"** ([Anleitung](http://programming.manessinger.com/tutorials/an-eclipse-glassfish-java-ee-6-tutorial/#heading_toc_j_23)).

###Als JUnit Test
Dazu wird ein gewöhnliches Java-Projekt erstellt. Folgende Buildpath-Einstellungen sind nötig:
- bei **Projekt** muss eine Referenz auf das EJB-Projekt **"EJBProject"** erstellt werden
- bei **Libraries** muss nebst dem **JRE** auch noch die **JUnit4-Library** sowie das externe JAR: **gf-client-module.jar** (im Unterverzeichnis \modules der Glassfish-Installation) eingetragen werden

```java
public class TestBean01 {

	private OrderManager serviceBean;

	@Before
	public void setUp() throws Exception {

		serviceBean =
				(OrderManager) new InitialContext().lookup("java:global/EARApp/EJBProject/OrderManagerBean!ch.x3m.beans.OrderManager");
	}

	@Test
	public void countOrders() {
		long cnt = serviceBean.countOrders().longValue();
		assertEquals("count Orders", 2, cnt);
	}
}
```


