package com.frewen.designpattern.chain.resposibility.sample.boss;

public class ManagerLeader extends Leader {
    @Override
    protected void handle(int money) {
        System.out.println("经理报销" + money + "元");
    }

    @Override
    protected int maxLimit() {
        return 10000;
    }
}