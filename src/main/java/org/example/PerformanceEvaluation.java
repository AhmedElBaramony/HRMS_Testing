package org.example;

public class PerformanceEvaluation {
    private Evaluation quality;
    private Evaluation productivity;
    private Evaluation punctuality;
    private Evaluation collaboration;
    private Evaluation initiative;

    public PerformanceEvaluation(Evaluation quality, Evaluation productivity, Evaluation punctuality,
                                 Evaluation collaboration, Evaluation initiative) {
        this.quality = quality;
        this.productivity = productivity;
        this.punctuality = punctuality;
        this.collaboration = collaboration;
        this.initiative = initiative;
    }

    public void setQuality(Evaluation quality) {
        this.quality = quality;
    }

    public void setProductivity(Evaluation productivity) {
        this.productivity = productivity;
    }

    public void setPunctuality(Evaluation punctuality) {
        this.punctuality = punctuality;
    }

    public void setCollaboration(Evaluation collaboration) {
        this.collaboration = collaboration;
    }

    public void setInitiative(Evaluation initiative) {
        this.initiative = initiative;
    }

    public Evaluation getQuality() {
        return quality;
    }

    public Evaluation getProductivity() {
        return productivity;
    }

    public Evaluation getPunctuality() {
        return punctuality;
    }

    public Evaluation getCollaboration() {
        return collaboration;
    }

    public Evaluation getInitiative() {
        return initiative;
    }

    public Evaluation getEvaluation(){
        double eval = quality.ordinal() + productivity.ordinal() + punctuality.ordinal()
                + collaboration.ordinal() + initiative.ordinal();
        eval /= 5;

        Evaluation evaluation;

        if (eval < 1.5) {
            evaluation = Evaluation.POOR;
        } else if (eval < 2.5) {
            evaluation = Evaluation.FAIR;
        } else if (eval < 3.5) {
            evaluation = Evaluation.GOOD;
        } else {
            evaluation = Evaluation.EXCELLENT;
        }
        return evaluation;
    }

}
