package org.opencds.cqf.cql.elm.execution;

import org.opencds.cqf.cql.execution.Context;

public class QueryLetRefEvaluator extends org.cqframework.cql.elm.execution.QueryLetRef {

    @Override
    public Object internalEvaluate(Context context) {
        return context.resolveVariable(this.getName()).getValue();
    }
}
