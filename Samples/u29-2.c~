#include <stdio.h> 
#include <stdlib.h> 
#include "ilp.h" 

/* Global variables */ 


ILP_Object ilp_program () 
{ 
{ 
  ILP_Object ilptmp74; 
  ILP_Object ilptmp75; 
ilptmp74 = ILP_Integer2ILP(11); 
ilptmp75 = ILP_Integer2ILP(22); 

  {
    ILP_Object x1 = ilptmp74;
    ILP_Object y2 = ilptmp75;
{ 
  ILP_Object ilptmp76; 
  ILP_Object ilptmp77; 
{ 
  ILP_Object ilptmp78; 
  ILP_Object ilptmp79; 
ilptmp78 = x1; 
ilptmp79 = y2; 
ilptmp76 = ILP_Plus(ilptmp78, ilptmp79);
} 
{ 
  ILP_Object ilptmp80; 
  ILP_Object ilptmp81; 
ilptmp80 = x1; 
ilptmp81 = y2; 
ilptmp77 = ILP_Times(ilptmp80, ilptmp81);
} 

  {
    ILP_Object x3 = ilptmp76;
    ILP_Object y4 = ilptmp77;
{ 
  ILP_Object ilptmp82; 
  ILP_Object ilptmp83; 
ilptmp82 = x3; 
ilptmp83 = y4; 
return ILP_Times(ilptmp82, ilptmp83);
} 

  }
}

  }
}

} 

static ILP_Object ilp_caught_program () {
  struct ILP_catcher* current_catcher = ILP_current_catcher;
  struct ILP_catcher new_catcher;

  if ( 0 == setjmp(new_catcher._jmp_buf) ) {
    ILP_establish_catcher(&new_catcher);
    return ilp_program();
  };
  return ILP_current_exception;
}

int main (int argc, char *argv[]) 
{ 
  ILP_START_GC; 
  ILP_print(ilp_caught_program()); 
  ILP_newline(); 
  return EXIT_SUCCESS; 
} 
