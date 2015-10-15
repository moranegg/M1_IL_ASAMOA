package com.paracamplus.ilp1.ilp1tme2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.paracamplus.ilp1.interfaces.IASTprogram;
import com.paracamplus.ilp1.interpreter.EmptyLexicalEnvironment;
import com.paracamplus.ilp1.interpreter.GlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.GlobalVariableStuff;
import com.paracamplus.ilp1.interpreter.Interpreter;
import com.paracamplus.ilp1.interpreter.OperatorEnvironment;
import com.paracamplus.ilp1.interpreter.OperatorStuff;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp1.interpreter.test.InterpreterTest;
import com.paracamplus.ilp1.parser.IParser;
import com.paracamplus.ilp1.parser.IParserFactory;
import com.paracamplus.ilp1.parser.ParseException;
import com.paracamplus.ilp1.tools.*;


@RunWith(Parameterized.class)
public class CountingTest extends InterpreterTest implements ICountingConstantProcess{
    
    protected static String rngFileName = "Grammars/grammar1.rng";
    protected static String samplesDirName = "Samples"; 
    protected static String pattern = "ur?[0-8]\\d*-[123456]";
    
    public CountingTest(final File file) {
        super(file);
    }
    
    protected File file;
    
    
    public void setParser (IParser parser) {
        this.parser = parser;
    }
    protected IParser parser;
    
    @Test
    public void processFile () throws Throwable {
        System.err.println("Testing " + file.getAbsolutePath() + " ...");
        assertTrue(file.exists());
        Input input = new InputFromFile(file);
        parser.setInput(input);
        File rngFile = new File(rngFileName);
        parser.setGrammar(rngFile);
        IASTprogram program = parser.getProgram();
        
        IGlobalVariableEnvironment gve = new GlobalVariableEnvironment();
        stdout = new StringWriter();
        GlobalVariableStuff.fillGlobalVariables(gve, stdout);
        IOperatorEnvironment oe = new OperatorEnvironment();
        OperatorStuff.fillUnaryOperators(oe);
        OperatorStuff.fillBinaryOperators(oe);
        Interpreter interpreter = new Interpreter(gve, oe);
        ILexicalEnvironment lexenv = new EmptyLexicalEnvironment();
        Object value = interpreter.visit(program, lexenv);
        String printing = stdout.toString();
        System.out.println("  Value: " + value);
        if ( ! "".equals(printing) ) {
            System.out.println("  Printing: " + printing);
        }
        checkResult(value);
        checkPrinting(printing);
    }

	@Override
	public int getNbConstantesDOM() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNbConstantesAST()   {
		return 0;
	}
}
