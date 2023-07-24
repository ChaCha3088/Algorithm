text = input()

text_set = set()

for i in range(len(text)):
    for j in range(i + 1, len(text) + 1):
        text_set.add(text[i:j])

print(len(text_set))