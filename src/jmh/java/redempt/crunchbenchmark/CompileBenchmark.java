package redempt.crunchbenchmark;

import com.ezylang.evalex.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.openjdk.jmh.annotations.*;

import redempt.crunch.Crunch;
import redempt.crunch.CompiledExpression;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class CompileBenchmark {

    @Benchmark
    public double crunchCompileSimpleExpression() {
        return Crunch.compileExpression("3*5").evaluate();
    }

    @Benchmark
    public double crunchCompileComplexExpression() {
        return Crunch.compileExpression("6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4").evaluate();
    }

    @Benchmark
    public Object evalExCompileSimpleExpression() throws Exception {
        return new Expression("3*5").evaluate();
    }

    @Benchmark
    public Object evalExCompileComplexExpression() throws Exception {
        return new Expression("6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4").evaluate();
    }

    @Benchmark
    public double exp4jCompileSimpleExpression() {
        return new ExpressionBuilder("3*5").build().evaluate();
    }

    @Benchmark
    public double exp4jCompileComplexExpression() {
        return new ExpressionBuilder("6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4 + 6.5*7.8^2.3 + (3.5^3+7/2)^3 -(5*4/(2-3))*4").build().evaluate();
    }

}