package behavioral.interpreter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Шаблон, решающий часто встречающуюся, но подверженную изменениям, задачу.
 * Также известен как Little (Small) Language
 */
public class InterpreterTest {

    @Test
    public void shouldInterpretExpressions() {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        assertTrue("John must be recognized as male", isMale.interpret("John"));
        assertTrue("Robert must be recognized as male", isMale.interpret("Robert"));
        assertTrue("Married Julie must be recognized", isMarriedWoman.interpret("Married Julie"));
        assertFalse("Alice must not be recognized as male", isMale.interpret("Alice"));

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a married women? " + isMarriedWoman.interpret("Married Julie"));
    }

    @Test
    public void shouldReturnFalseForNullContext() {
        assertFalse(getMaleExpression().interpret(null));
    }

    // Rule: Robert and John are male
    public static Expression getMaleExpression() {
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    // Rule: Julie is a married women
    public static Expression getMarriedWomanExpression() {
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }
}
