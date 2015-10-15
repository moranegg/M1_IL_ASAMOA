package com.paracamplus.ilp1.ilp1tme2;

import java.util.List;
import java.util.Vector;

import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASToperator;
import com.paracamplus.ilp1.interfaces.IASTprogram;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp1.interpreter.Interpreter;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperator;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.Invocable;

public class Counting extends Interpreter{
	int counter = 0;


    public Counting(IGlobalVariableEnvironment gve, IOperatorEnvironment oe) {
    	super(gve, oe);
	}


	@Override
	public Object visit(IASTboolean iast, ILexicalEnvironment lexenv) 
            throws EvaluationException {
    	counter++;
        return null;
    }
    
    @Override
	public Object visit(IASTinteger iast, ILexicalEnvironment lexenv) 
            throws EvaluationException {
    	counter++;
        return null;
    }
    
    @Override
	public Object visit(IASTfloat iast, ILexicalEnvironment lexenv) 
            throws EvaluationException {
    	counter++;
        return null;
    }
    
    @Override
	public Object visit(IASTstring iast, ILexicalEnvironment lexenv) 
            throws EvaluationException {
    	counter++;
        return null;
    }
    
    public int getCounter(){
    	return this.counter;
    }

}
