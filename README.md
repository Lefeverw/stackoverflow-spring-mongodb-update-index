# stackoverflow-spring-mongodb-update-index

Example for question: https://stackoverflow.com/questions/76878180/how-to-update-index-in-mongodb-when-using-spring

## Steps for migration

1. Insert data with the original index

In [application.yml](./src/main/resources/application.yml) point `mongock.migration-scan-package` to a non-existing package (e.g. `empty`).

```yaml
mongock:
  migration-scan-package:
    - empty
#    - com.wouterlefever.stackoverflow.changeset
```

In the entity `Person` use the initial index:

```
@CompoundIndex(
        name = "unique_name_with_age",
        def = "{ 'firstName':1 , 'lastName':1 }",
        unique = true)
//@CompoundIndex(
//        name = "unique_name_with_age",
//        def = "{ 'firstName':1 , 'lastName':1, 'ssn':1 }",
//        unique = true)
@Document
public class Person {
```
And run the application.

2. Delete the existing index during migration.

Comment out the insert of data in `Application`

```
    @Override
    public void run(String... args) {
//        Person person = new Person("John", "Doe", "1");
//        personRepository.save(person);
    }
```

Comment out the index definitions in `Person`.

```
//@CompoundIndex(
//        name = "unique_name_with_age",
//        def = "{ 'firstName':1 , 'lastName':1 }",
//        unique = true)
//@CompoundIndex(
//        name = "unique_name_with_age",
//        def = "{ 'firstName':1 , 'lastName':1, 'ssn':1 }",
//        unique = true)
@Document
public class Person {
```

In [application.yml](./src/main/resources/application.yml) point `mongock.migration-scan-package` to the `changeset` package.

```yaml
mongock:
  migration-scan-package:
#    - empty
    - com.wouterlefever.stackoverflow.changeset
```
And run the application.

3. Add the new index

Add the new index to the entity `Person`

```
@CompoundIndex(
        name = "unique_name_with_age",
        def = "{ 'firstName':1 , 'lastName':1, 'ssn':1 }",
        unique = true)
@Document
public class Person {
```

And run the application.