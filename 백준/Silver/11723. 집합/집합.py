import sys

input = sys.stdin.readline
s = 0b0

m = int(input())
for _ in range(m):
    operation_line = input().split()
    operation = operation_line[0]

    if operation == "all":
        s = 0b111111111111111111111
    elif operation == "empty":
        s = 0b0
    elif operation == "add":
        s |= (0b1 << int(operation_line[1]))
        continue
    elif operation == "remove":
        s &= (~(0b1<< int(operation_line[1])))
        continue
    elif operation == "check":
        print(((s >> int(operation_line[1])) & 1))
    elif operation == "toggle":
        s ^= (0b1 << (int(operation_line[1])))



