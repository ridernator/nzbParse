//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.23 at 11:23:32 AM BST 
//


package com.rider.nzbparse.types;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rider.nzb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rider.nzb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Head }
     * 
     */
    public Head createHead() {
        return new Head();
    }

    /**
     * Create an instance of {@link Meta }
     * 
     */
    public Meta createMeta() {
        return new Meta();
    }

    /**
     * Create an instance of {@link File }
     * 
     */
    public File createFile() {
        return new File();
    }

    /**
     * Create an instance of {@link Groups }
     * 
     */
    public Groups createGroups() {
        return new Groups();
    }

    /**
     * Create an instance of {@link Segments }
     * 
     */
    public Segments createSegments() {
        return new Segments();
    }

    /**
     * Create an instance of {@link Nzb }
     * 
     */
    public Nzb createNzb() {
        return new Nzb();
    }

    /**
     * Create an instance of {@link Segment }
     * 
     */
    public Segment createSegment() {
        return new Segment();
    }

    /**
     * Create an instance of {@link Group }
     * 
     */
    public Group createGroup() {
        return new Group();
    }

}
