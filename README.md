# JAVA MODULE FOR MOOZISMS
Moozisms JAVA Library

> Recover your API Credentials on Moozisms Dashboard

### INSTALLATION MODULE

https://github.com/Moozisms/APIClient-JavaLibrary/blob/master/dist/Moozisms-api.jar

### JAVADOC

https://github.com/Moozisms/APIClient-JavaLibrary/blob/master/dist/Moozisms-api-javadoc.jar

### SOURCES

https://github.com/Moozisms/APIClient-JavaLibrary/blob/master/dist/Moozisms-api-sources.jar


### WEB SITE
http://moozisms.com/

### USAGE

> SENDING Simple SMS

```java

        MoozismsApiClient apisms = new Moozisms();
        boolean test = false;

        try {

            test = apisms.sendSimple("API_KEY", "API_SECRET","PHONENUMBER", "SENDER_ID", "MESSAGE");

            System.out.println(test ? "Message envoyé" : "Message non envoyé");
        } catch (Exception e) {
            System.out.println("Echec de l'opération ");
        }

```

        
> SENDING Bulk SMS

```java

        MoozismsApiClient apisms = new Moozisms();
        boolean test = false;
        Map<String,Boolean> resultat;
        List<String> bulkList = new ArrayList<>();
        bulkList.add("PHONENUMBER_1");
        bulkList.add("PHONENUMBER_2");

        try {

            resultat = apisms.sendGroup("API_KEY", "API_SECRET","PHONENUMBER",bulkList, "SENDER_ID", "MESSAGE");

            for(Map.Entry<String,Boolean> mp : resultat.entrySet()){
                System.out.println("\nNuméro : "+mp.getKey()+" Envoyé :"+mp.getValue()+"\n");
            }
        } catch (Exception e) {
            System.out.println("\nEchec de l'operation ");
        }
```

### LIST OF EXCEPTION

- InternalErrorException
- MessageNotSentException
- NetworkNotSupportedException
- InsufficientSmsException
- InvalidAccessKeyException
- InvalidPhoneNumberException
- InvalidSenderIdException


### LIST OF FUNCTIONALITY AVALAIBLE ON THE WEB SITE

- SENDING Simple SMS
- SENDING Bulk SMS
- MANAGE CONTACT 
- CHECK SMS STATUS 
- CHECK SMS REPORT 



### LICENCE 
> MIT
