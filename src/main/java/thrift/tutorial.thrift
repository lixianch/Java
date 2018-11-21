namespace java thrift.example1
struct Person {
    1:string name;
    2:i16 age;
    3:string sex;
}

service PersonService{
    Person queryPerson(1:i16 id);
}