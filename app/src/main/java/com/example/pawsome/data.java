package com.example.pawsome;

public class data {
    Weight weight=new Weight();
   Height height=new Height();
    int id;
    String name;
    String bred_for;
   String life_span;
    String temperament;
   Image image;

   public data(){}
    public data(Weight weight,Height height,int id,String name,String bred_for,String life_span,String temperament,Image url)
    {
        if(weight.imperial==null)
            this.weight.imperial="";
        else
            this.weight.imperial = weight.imperial;
        if(weight.metric==null)
            this.weight.metric="";
        else
            this.weight.metric = weight.metric;
        if(height.imperial==null)
            this.height.imperial="";
        else
            this.height.imperial = height.imperial;
        if(height.metric==null)
            this.height.metric="";
        else
            this.height.metric = height.metric;
       this.id=id;
       this.name=name;
        if(this.bred_for==null)
            this.bred_for="";
        else
            this.bred_for = bred_for;
        if(this.life_span==null)
            this.life_span="";
        else
            this.life_span = life_span;
        if(this.temperament==null)
            this.temperament="";
        else
            this.temperament = temperament; ;
       this.image.url=image.url;
    }
    public Weight getWeight() {     return weight; }

    public void setWeight(Weight weight) {
        if(weight.imperial==null)
            this.weight.imperial="";
        else
            this.weight.imperial = weight.imperial;
        if(weight.metric==null)
            this.weight.metric="";
        else
            this.weight.metric = weight.metric; }

    public Height getHeight() {        return height; }

    public void setHeight(Weight height) {
        if(height.imperial==null)
            this.height.imperial="";
        else
            this.height.imperial = height.imperial;
        if(height.metric==null)
            this.height.metric="";
        else
            this.height.metric = height.metric;
    }

    public int getId() {        return id; }

    public void setId(int id) {        this.id = id; }

    public String getName() {        return name; }

    public void setName(String name) {        this.name = name; }

    public String getBred_for() {        return bred_for; }

    public void setBred_for(String bred_for) {
       if(this.bred_for==null)
           this.bred_for="";
    else
        this.bred_for = bred_for; }

    public String getLife_span() {        return life_span; }

    public void setLife_span(String life_span) {
       if(this.life_span==null)
           this.life_span="";
       else
       this.life_span = life_span; }

    public String getTemperament() {        return temperament; }

    public void setTemperament(String temperament) {
       if(this.temperament==null)
           this.temperament="";
       else
           this.temperament = temperament; }

    public String getUrl() {        return image.url; }

    public void setUrl(Image image) {        this.image.url =image.url; }
}
