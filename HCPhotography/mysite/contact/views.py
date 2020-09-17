from django.shortcuts import redirect, render
from .models import Message
from django.contrib import messages

# Create your views here.
def contact(request):
    # photos = Photo.objects.all()
    return render(request, "contact.html")

def sendContact(request):
    if request.method == 'POST':
        name = request.POST['name']
        email = request.POST['email']
        subject = request.POST['subject']
        message = request.POST['message']

        interum_message = Message.save(name=name, email=email, subject=subject, message=message)

        if interum_message is not None:
            messages.info(request, "Thank you for your feedback!")
            return redirect('/')
        else:
            messages.info(request, 'Please try again')
            return redirect('contact')
    else:
        return render(request, 'sixteen')  