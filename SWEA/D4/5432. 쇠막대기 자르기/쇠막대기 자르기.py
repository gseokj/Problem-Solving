for x in range(1, int(input()) + 1):
	ir= input()
	stack=[]
	cnt = 0
	for i in range(len(ir)):
	    if ir[i] == "(":
	        stack.append("(")
	    else :
	        if ir[i-1]=="(":
	            stack.pop()
	            cnt+=len(stack)
	            
	        else :
	            stack.pop()
	            cnt+=1
	print(f"#{x}",cnt)