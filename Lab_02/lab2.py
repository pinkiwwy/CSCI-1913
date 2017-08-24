#Name: Wing Yi Wong

import types
from functools import reduce

class Zillion:

    def __init__(self,digits):
        self.digits = []

        for digit in digits:
            if (digit == " ") or digit == ",":
                pass
            elif (digit >= "0") and (digit <= "9"):
                self.digits += [int(digit)]
            else:
                raise RuntimeError

        if self.digits == []:
            raise Exception
                  

    def increment(self):
        length = len(self.digits)

        while (self.digits[length-1] == 9) and (length > 0):
            self.digits[length-1] = 0
            length = length - 1

        if length>0:
            self.digits[length-1] = self.digits[length-1] + 1

        else:
            self.digits = [1] + self.digits
            

    def isZero(self):
        return reduce(lambda x,y: x+y, self.digits) == 0 
        

    def toString(self):
        number = ""
        for i in self.digits:
            number = number + str(i)
        return number
    
#Result:
#>>> z = Zillion('999 999 999 998')
#>>> z.isZero()
#False    
#>>> z.increment()
#>>> print(z.toString())
#999999999999
#>>> z.increment()
#>>> print(z.toString())
#1000000000000
#>>> z.increment()
#>>> print(z.toString())
#1000000000001
    
#>>> z = Zillion('')
#Traceback (most recent call last):
#  File "<pyshell#7>", line 1, in <module>
#    z = Zillion('')
#  File "/Users/Pinki/Documents/lab2 Wing Yi Wong.py", line 21, in __init__
#    raise Exception
#Exception

#>>> z = Zillion('0')
#>>> z.isZero()
#True

#>>> z = Zillion('999 123 456 99')
#>>> print(z.toString())
#99912345699
#>>> z.increment()
#>>> print(z.toString())
#99912345700 

    
