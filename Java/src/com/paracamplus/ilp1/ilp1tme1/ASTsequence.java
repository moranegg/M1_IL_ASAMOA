package com.paracamplus.ilp1.ilp1tme1;

import java.util.Arrays;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.ilpItme1.sequence.IASTSequence;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvisitor;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public class ASTsequence extends com.paracamplus.ilp1.ast.ASTsequence implements IASTSequence {
   
    
    public ASTsequence(IASTexpression[] expressions) {
		super(expressions);
	}

	public IASTexpression[] getAllButLastInstructions()
			throws EvaluationException {
		return Arrays.copyOfRange(expressions, 0, expressions.length - 1);
	}
}
