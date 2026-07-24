package com.tesco;

public enum Skill {


    BAKERY("bakery",2);

 /*   Checkout Cashier	£1.2/hour
    Customer Service	£1.3/hour
    com.tesco.Shift Leader	£3/hour
    Security	£1/hour
    Cleaning	£1/hour
    Delivery Driver	£2/hour*/


    Skill() {

    }

    private String skill;
    private double amount;
    Skill(String skill, double amount) {
        this.skill = skill;
        this.amount = amount;
    }
    public Skill getSkill() {
        return Skill.valueOf(skill);
    }

    public double getAmount() {
        return amount;
    }





}
