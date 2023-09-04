# Spring-XML-Validation
Sample code to parse xml and xml validation using JAXB in Spring Boot

# http://localhost:8080/validate 
This will validate the passed xml payload to this API against the person.xsd schema. 

`<?xml version="1.0" encoding="UTF-8" ?>
<individual>
    <name>Tejinder</name>
    <address>
        <zip>00001</zip>
        <city>New York</city>
    </address>
</individual>`




# http://localhost:8080/process 
This API will parse the incoming XML Payload and fetch the individual elements from that payload.

`<item>
    <id>1</id>
    <name>itemname</name>
</item>`
