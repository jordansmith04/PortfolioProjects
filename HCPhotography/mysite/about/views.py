from django.shortcuts import render

# Create your views here.
def about(request):
    # photos = Photo.objects.all()
    return render(request, "about.html")