package com.paracamplus.ilp1.ilp1tme2;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public interface ICountingConstantProcess {
	
	//compte les constantes a partir du DOM
	public int getNbConstantesDOM();
	
	
	//compte les constantes a partir de L'AST
	public int getNbConstantesAST() throws EvaluationException;

}
