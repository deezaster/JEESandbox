JEESandbox
==========

Projektbeschreibung
-------------------
Es handelt sich hierbei um ein **Java EE Testprojekt** für **Glassfish 4** mit **Eclipselink** als JPA Persistenzprovider, **MySQL** als Datenbank und mit **JUnit** Tests. 

Der Code wurde mit Hilfe der IDE 'Eclipse Juno' auf einem MacBook Pro realisiert. 

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

Empfehlen kann ich folgende Bücher:

- **EJB 3 Developer Guide** (ISBN 978-1-847195-60-9)
- **Mastering EnterpriseJavaBeans™ 3.0** (ISBN 978-0-471-78541-5)
- **Pro JPA 2: Mastering the Java™Persistence API** (ISBN 978-1-4302-1956-9)




Tips & Tricks
=============

Bean testen
-----------
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





