#include <stdio.h> 
#include <stdlib.h> 
#include "ilp.h" 

/* Global variables */ 


ILP_Object ilp_program () 
{ 
{ 
  ILP_Object ilptmp2; 
  ILP_Object ilptmp3; 
ilptmp2 = ILP_FALSE; 
{ 
  ILP_Object ilptmp4; 
  ILP_Object ilptmp5; 
ilptmp4 = ILP_Integer2ILP(710); 
ilptmp5 = ILP_Integer2ILP(2); 
ilptmp3 = ILP_Or(ilptmp4, ilptmp5);
} 
return ILP_Or(ilptmp2, ilptmp3);
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
