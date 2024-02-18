grammar XPathGrammar;

ap
	: doc '/' rp #SlashAp
	| doc '//' rp #DslashAp
	;

rp
    	: Name #SingleTagRp
    	| '*' #SingleStarRp
   	    | '.' #SingleSelfRp
    	| '..' #SingleParentRp
    	| 'text()' #SingleTextRp
    	| '@' Name #SingleAttrRp
    	| '(' rp ')' #SingleParenthRp
    	| rp '/' rp #BinarySlashRp
    	| rp '//' rp #BinaryDslashRp
    	| rp ',' rp # BinaryCombineRp
    	| rp '[' f ']'#FilterRp
    	;

f
	    : rp #RpF
	    | rp ('=' | 'eq') rp # BinaryEqualRpF
	    | rp ('==' | 'is') rp # BinaryIsRpF
	    | rp ('=' | 'eq') String # RpEqualStringF
        | '(' f ')' #ParenthF
	    | f 'and' f #BinaryAndF
	    | f 'or' f #BinaryOrF
	    | 'not' f #NegF
        ;

doc
	:'doc' '(' String ')';

Name : [a-zA-Z_][a-zA-Z0-9_.-]*;
String: '"' (~'"')* '"';
WhiteSpace: [ \n\t\r]+ -> skip;
