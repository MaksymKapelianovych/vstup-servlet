package ua.vstup.domain;


public class RequirementInfo {
    private Subject firstSubject;
    private Subject secondSubject;
    private Subject thirdSubject;
    private Subject fourthSubject;
    private Subject fifthSubject;

    private RequirementInfo(Builder builder) {
        firstSubject = builder.firstSubject;
        secondSubject = builder.secondSubject;
        thirdSubject = builder.thirdSubject;
        fourthSubject = builder.fourthSubject;
        fifthSubject = builder.fifthSubject;
    }

    public Subject getFirstSubject() {
        return firstSubject;
    }

    public Subject getSecondSubject() {
        return secondSubject;
    }

    public Subject getThirdSubject() {
        return thirdSubject;
    }

    public Subject getFourthSubject() {
        return fourthSubject;
    }

    public Subject getFifthSubject() {
        return fifthSubject;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder{
        private Subject firstSubject;
        private Subject secondSubject;
        private Subject thirdSubject;
        private Subject fourthSubject;
        private Subject fifthSubject;

        private Builder(){}

        public Builder withFirstSubject(Subject firstSubject){
            this.firstSubject = firstSubject;
            return this;
        }
        public Builder withSecondSubject(Subject secondSubject){
            this.secondSubject = secondSubject;
            return this;
        }
        public Builder withThirdSubject(Subject thirdSubject){
            this.thirdSubject = thirdSubject;
            return this;
        }
        public Builder withFourthSubject(Subject fourthSubject){
            this.fourthSubject = fourthSubject;
            return this;
        }
        public Builder withFifthSubject(Subject fifthSubject){
            this.fifthSubject = fifthSubject;
            return this;
        }

        public RequirementInfo build() { return new RequirementInfo(this); }
    }
}
