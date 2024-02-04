grammar XPathGrammar;

ap
	: doc '/' rp
	| doc '//' rp
	;

rp
    	: Name
    	| '*'
   	    | '.'
    	| '..'
    	| 'text()'
    	| '@' Name
    	| '(' rp ')'
    	| rp '/' rp
    	| rp '//' rp
    	| rp '[' f ']'
    	| rp ',' rp
    	;

f
	    : rp
	    | rp ('=' | 'eq') rp
	    | rp ('==' | 'is') rp
	    | rp ('=' | 'eq') String
        | '(' f ')'
	    | f 'and' f
	    | f 'or' f
	    | 'not' f
        ;

doc
	:'doc' '(' String ')';

Name: [a-zA-Z0-9-]+;
String: '"' (~'"')* '"';
WhiteSpace: [ \n\t\r]+ -> skip;