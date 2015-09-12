/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp1.compiler.ast;

import com.paracamplus.ilp1.ast.ASTinvocation;
import com.paracamplus.ilp1.compiler.interfaces.IASTCprimitiveInvocation;
import com.paracamplus.ilp1.compiler.interfaces.IASTCvisitor;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;

public class ASTCprimitiveInvocation extends ASTinvocation
implements IASTCprimitiveInvocation {
    
    public ASTCprimitiveInvocation(IASTvariable function, 
                                  IASTexpression[] arguments) {
        super(function, arguments);
    }

    @Override
	public <Result, Data, Anomaly extends Throwable> Result 
        accept(IASTCvisitor<Result, Data, Anomaly> visitor, Data data)
            throws Anomaly {
        return visitor.visit(this, data);
    }
}
