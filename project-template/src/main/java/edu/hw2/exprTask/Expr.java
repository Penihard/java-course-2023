package edu.hw2.exprTask;

public sealed interface Expr {

    double evaluate();

    public record Constant(double expr) implements Expr {
        @Override
        public double evaluate() {
            return expr;
        }
    }

    public record Negate(Expr expr) implements Expr {
        @Override
        public double evaluate() {
            return  -expr.evaluate();
        }
    }

    public record Exponent(Expr base, Expr power) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(base.evaluate(), power.evaluate());
        }
    }

    public record Addition(Expr op1, Expr op2) implements Expr {
        @Override
        public double evaluate() {
            return op1.evaluate() + op2.evaluate();
        }
    }

    public record Multiplication(Expr op1, Expr op2) implements Expr {
        @Override
        public double evaluate() {
            return op1.evaluate() * op2.evaluate();
        }

    }
}
