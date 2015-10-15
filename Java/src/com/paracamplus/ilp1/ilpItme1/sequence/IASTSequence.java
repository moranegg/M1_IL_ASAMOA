package com.paracamplus.ilp1.ilpItme1.sequence;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;



public interface IASTSequence extends com.paracamplus.ilp1.interfaces.IASTsequence{
	
	IASTexpression [] getAllButLastInstructions () throws EvaluationException ;

}
