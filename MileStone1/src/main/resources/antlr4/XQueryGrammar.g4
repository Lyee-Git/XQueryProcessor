grammar XQueryGrammar;
import XPathGrammar;

xq
    : VAR #VarXq
    | String #StringXq
    | ap #ApXq
    | '(' xq ')' #ParenthXq
    | xq ',' xq # BinaryCombineXq
    | xq '/' rp #BinarySlashXq
    | xq '//' rp #BinaryDslashXq
    | '<' Name '>' '{' xq '}' '</' Name '>' #TagXq
    | for (let)? (where)? return #ForXq
    | let xq #LetXq
    ;

for : 'for' VAR 'in' xq (',' VAR 'in' xq)*;

let : 'let' VAR ':=' xq (',' VAR ':=' xq)*;

where : 'where' cond;

return : 'return' xq;

cond
    : xq ('=' | 'eq') xq #BinaryEqualCond
    | xq ('==' | 'is') xq #BinaryIsCond
    | 'empty (' xq ')' #EmpCond
    | 'some' VAR 'in' xq (',' VAR 'in' xq)* 'satisfies' cond #SatCond
    | '(' cond ')' #ParenthCond
    | cond 'and' cond #AndCond
    | cond 'or' cond #OrCond
    | 'not' cond #NotCond
    ;

VAR: '$' Name;
