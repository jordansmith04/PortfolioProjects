from django.shortcuts import render
# Create your views here.

def method(request):
    # photos = Photo.objects.all()
    return render(request, "products.html")