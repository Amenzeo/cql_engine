package org.opencds.cqf.cql.elm.execution;

import org.opencds.cqf.cql.execution.Context;

public class CodeRefEvaluator extends org.cqframework.cql.elm.execution.CodeRef {

    @Override
    protected Object internalEvaluate(Context context) {
        return context.resolveCodeRef(this.getName()).evaluate(context);
    }
}
