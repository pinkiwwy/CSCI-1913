#Author: Pinki Wong

def left(e):
    return e[0]     #tuple("a","+","b") returns "a"
def op(e):
    return e[1]     #returns "b"
def right(e):
    return e[2]     #returns "c"

def isInside(v,e):
    if type(e)==str:    #test if e is string 
        return v == e   #test if v is inside e
    else:               #else if e is tuple
        return isInside(v, left(e)) or isInside(v, right(e))
        #recursion here if tuple inside tuple

def solve(v,q):
    if isInside(v,left(q)):
        return solving(v,q)
    elif isInside(v,right(q)) :
        return solving(v, [right(q), op(q), left(q)])
        #tuple is immutable, so make up new
    else:
        return None

def solving(v,q):
    if v == left(q):    #if v equal to left hand side, completed
        return q
    elif op(left(q)) == "+":#if operators on the left-> associated functions
        return solvingAdd(v,q)
    elif op(left(q)) == "-":
        return solvingSubtract(v,q)
    elif op(left(q)) == "*":
        return solvingMultiply(v,q)
    elif op(left(q)) == "/":
        return solvingDivide(v,q)
    else:
        return None

def solvingAdd(v,q):
    A = left(left(q))
    B = right(left(q))
    C = right(q)

    if isInside(v,A):
        eq = [A, "=", [C, "-", B]]  #set tuple inside tuple as q
        return solving(v,eq)
    
    elif isInside(v,B):
        eq = [B, "=", [C, "-", A]]
        return solving(v,eq)

def solvingSubtract(v,q):
    A = left(left(q))
    B = right(left(q))
    C = right(q)

    if isInside(v,A):
        eq = [A, "=", [C, "+", B]]
        return solving(v,eq)
    
    elif isInside(v,B):
        eq = [B, "=", [A, "-", C]]
        return solving(v,eq)

def solvingMultiply(v,q):
    A = left(left(q))
    B = right(left(q))
    C = right(q)

    if isInside(v,A):
        eq = [A, "=", [C, "/", B]]
        return solving(v,eq)
    
    elif isInside(v,B):
        eq = [B, "=", [C, "/", A]]
        return solving(v,eq)

def solvingDivide(v,q):
    A = left(left(q))
    B = right(left(q))
    C = right(q)

    if isInside(v,A):
        eq = [A, "=", [C, "*", B]]
        return solving(v,eq)
    
    elif isInside(v,B):
        eq = [B, "=", [A, "/", C]]
        return solving(v,eq)
    
            
