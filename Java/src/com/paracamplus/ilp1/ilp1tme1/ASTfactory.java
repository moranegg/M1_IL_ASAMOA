/* *****************************************************************
 * TME1
 * 
 ***************************************************************** */
package com.paracamplus.ilp1.ilp1tme1;


import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.parser.IParserFactory;

public class ASTfactory extends com.paracamplus.ilp1.ast.ASTfactory implements IParserFactory {


    @Override
	public IASTsequence newSequence(IASTexpression[] asts) {
        return new ASTsequence(asts);
    }


}
