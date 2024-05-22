package myexamples.beans;


public class Car {

  private Integer id;
  private String producer;
  private String model;
  private Integer year;
  private String color;
  private Double price;

  public Car(Integer id,
      String producer,
      String model,
      Integer year,
      String color,
      Double price) {
    this.id = id;
    this.producer = producer;
    this.model = model;
    this.year = year;
    this.color = color;
    this.price = price;
  }

  @Override
  public String toString() {
    return "Car{" +
        "id = " + id +
        ", producer = '" + producer + '\'' +
        ", model = '" + model + '\'' +
        ", year = " + year +
        ", color = '" + color + '\'' +
        ", price = " + price +
        '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProducer() {
    return producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
