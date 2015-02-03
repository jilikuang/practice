%%
ab([ac]*b+c)*[ac]*b+a	{ printf("pattern: %s\n", yytext); }
.|\n	{ printf("Ignored\n"); }
