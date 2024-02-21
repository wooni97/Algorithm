def isRight(pairs):
    stack = []

    for pair in pairs:
        if pair == "(":
            stack.append(pair)
        elif pair == ")":
            if stack:
                stack.pop()
            else:
                return False

    if stack:
        return False

    return True

def sepUV(p):
    pair_1 = 0
    pair_2 = 0
    u, v = "", ""
    for i in range(len(p)):
        if p[i] == "(":
            pair_1 += 1
        elif p[i] == ")":
            pair_2 += 1

        if pair_1 > 0 and pair_2 > 0 and pair_1 == pair_2:
            u = p[0 : i + 1]
            v = p[i + 1:] if i + 1 < len(p) else ""
            break
    return u, v

def reverse_parentheses(u):
    result = ""
    for char in u:
        if char == "(":
            result += ")"
        elif char == ")":
            result += "("
    return result

def rec(p):
    result = ""

    if p == "":
        return p

    u, v = sepUV(p)

    if isRight(u):
        result = u + rec(v)
    else:
        result = "("
        result += rec(v)
        result += ")"

        if len(u) > 0:
            u = u[1:]
        if len(u) > 0:
            u = u[:len(u)-1]

        result += reverse_parentheses(u)

    return result

def solution(p):
    return rec(p)


