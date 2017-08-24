#Wing Yi Wong

from functools import reduce
class Sieve:

    def __init__(self,max):
       
        if max < 0:
            raise Exception
        else:
            
            numbers = list(range(0, max))
            
            for i in range(0, max):
                if i == 0 or i == 1:
                    numbers[i] = False
                else:
                    numbers[i] = True
            self.max = numbers


    def findPrimes(self):

        for i in range(0,len(self.max)):

            if self.max[i] == True:
                for j in range(1,len(self.max)-i):

                    if ((i+j) % i == 0):
                        self.max[i+j] = False
                        
    def howMany(self):
        return reduce(lambda x,y: x + (1 if y == True else 0),self.max) 
        
        

    def toList(self):
        primes = []

        for i in range(0,len(self.max)):
            
            if self.max[i] == False:
                pass
            elif self.max[i] == True:
                primes = primes + [i]
                
        return primes



#>>> S=Sieve(4)
#>>> S.toList()
#[2, 3, 4]
#>>> S.howMany()
#3
#>>> S.findPrimes()
#>>> S.toList()
#[2, 3]
#>>> S.howMany()
#2
#>>> S=Sieve(100)
#>>> S.findPrimes()
#>>> S.toList()
#[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]
#>>> S.howMany()
#25
#>>> S=Sieve(-1)
#Traceback (most recent call last):
#  File "<pyshell#20>", line 1, in <module>
#    S=Sieve(-1)
#  File "/Users/Pinki/Desktop/lab3.py", line 10, in __init__
#    raise Exception
#Exception
#>>> 
