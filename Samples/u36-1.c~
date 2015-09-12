#include <stdio.h> 
#include <stdlib.h> 
#include "ilp.h" 

/* Global variables */ 
ILP_Object pi;


ILP_Object ilp_program () 
{ 
{ 
  ILP_Object ilptmp102; 
  ILP_Object ilptmp103; 
ilptmp102 = ILP_PI; 
ilptmp103 = ILP_Float2ILP(0.1415926535); 
return ILP_Minus(ilptmp102, ilptmp103);
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
