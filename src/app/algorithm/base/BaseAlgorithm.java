package app.algorithm.base;

import app.models.Edges;

public abstract class BaseAlgorithm {

    protected int distance = Integer.MAX_VALUE;

    public int getDistance() {
        return this.distance;
    }

    public String printSteps(Edges origin, Edges destination) {
        return ""; //insira a lógica que eu n sei ainda aqui (eu lembro q tu fez mas n consigo achar)
    }

}
