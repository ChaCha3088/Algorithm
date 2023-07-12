# the inflation rate is still above 50%

# the initial price of a good at the start of a time period
# the daily price change for that good over the observed time period.



# the number of days the prices are observed
N = int(input())

# a positive integer indicating the initial price of the desired good on day 1
price = int(input())

# The next n − 1 lines contain n − 1 integers showing the daily change in the price of the good, in order from day 2 to day n
for i in range(2, N + 1):
    price += int(input())

# the final price of the good on day n
print(price)