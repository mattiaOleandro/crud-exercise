package co.develhope.crudexercise.entities;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String modelName;
    private String type;

    public Car(){}

    public Car(Long id, String modelName, String type){
        this.setId(id);
        this.setModelName(modelName);
        this.setType(type);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "----------------\nCar:" + "\nid = " + id + "\nmodelName = " + modelName + "\ntype = " + type + "\n----------------";
    }
}
