app = []
for i in range(10):
    A = int(input()) % 42
    if A not in app :
        
        app.append(A)
print(len(app))