
N = int(input())

positives = []
ones = []
negatives = []
zeros = []

answer = 0
for i in range(N) :
    number = int(input())

    if number > 1 :
        positives.append(number)
    elif number == 1 :
        ones.append(number)
    elif number == 0 :
        zeros.append(number)
    elif number < 0 :
        negatives.append(number)

positives.sort()
negatives.sort(reverse=True)

while len(positives) >= 2 :
    a = positives.pop()
    b = positives.pop()
    answer += (a * b)

if positives :
    answer += positives[0]

while len(negatives) >= 2 :
    a = negatives.pop()
    b = negatives.pop()
    answer += (a * b)

while negatives and zeros :
    negatives.pop()
    zeros.pop()

if negatives :
    answer += sum(negatives)
if ones :
    answer += sum(ones)

print(answer)