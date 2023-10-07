package redempt.crunchbenchmark;

import com.ezylang.evalex.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.openjdk.jmh.annotations.*;
import redempt.crunch.CompiledExpression;
import redempt.crunch.Crunch;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class EvalBenchmark {

    @State(Scope.Benchmark)
    public static class BenchmarkState {

        public int x = 0;

        public CompiledExpression simpleCrunchExpression;
        public Expression simpleEvalExExpression;
        public net.objecthunter.exp4j.Expression simpleExp4jExpression;

        public CompiledExpression constantCrunchExpression;
        public Expression constantEvalExExpression;
        public net.objecthunter.exp4j.Expression constantExp4jExpression;

        @Setup
        public void setup() {
            simpleCrunchExpression = Crunch.compileExpression("(10*$1)+5/2");
            simpleEvalExExpression = new Expression("(10*x)+5/2");
            simpleExp4jExpression = new ExpressionBuilder("(10*x)+5/2").variable("x").build();

            constantCrunchExpression = Crunch.compileExpression("6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4");
            constantEvalExExpression = new Expression("6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4");
            constantExp4jExpression = new ExpressionBuilder("6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4").build();
        }

    }

//    @Benchmark
//    public double crunchSimpleEval(BenchmarkState state) {
//        return state.simpleCrunchExpression.evaluate(state.x++);
//    }
//
//    @Benchmark
//    public double exp4jSimpleEval(BenchmarkState state) {
//        return state.simpleExp4jExpression.setVariable("x", state.x++).evaluate();
//    }
//
//    @Benchmark
//    public Object evalExSimpleEval(BenchmarkState state) throws Exception {
//        return state.simpleEvalExExpression.with("x", state.x++).evaluate();
//    }
//
//    @Benchmark
//    public double crunchConstantEval(BenchmarkState state) {
//        return state.constantCrunchExpression.evaluate();
//    }
//
//    @Benchmark
//    public double exp4jConstantEval(BenchmarkState state) {
//        return state.constantExp4jExpression.evaluate();
//    }

    @Benchmark
    public Object evalExConstantEval(BenchmarkState state) throws Exception {
        return state.constantEvalExExpression.evaluate();
    }

}