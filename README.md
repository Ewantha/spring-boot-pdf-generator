# PDF Generator
## _spring-boot-pdf-generator_

Application to create a PDF using an API. This can be used as reference for creating PDF documents using the iText java library.

## API Documentation
[Open API Docs](http://localhost:8080/v3/api-docs)

[Swagger UI](http://localhost:8080/swagger-ui/index.html)

## Getting Started

Documents will be created at ${localPath.pdf}

1. Create a simple document with a heading and two paragraphs.
```curl
curl --location --request POST 'http://localhost:8080/document/pdf' \
--header 'Content-Type: application/json' \
--data-raw '{
    "DocumentName": "Document1",
    "Content": [
        {
            "Type": "Paragraph",
            "Font": {
                "Type": "Helvetica-Bold",
                "Size": 24,
                "Style": 4,
                "Color": {
                    "Red": 0,
                    "Green": 0,
                    "Blue": 0
                }
            },
            "Text": "Title"
        },
        {
            "Type": "Whitespace"
        },
        {
            "Type": "Paragraph",
            "Font": {
                "Type": "Helvetica",
                "Size": 12,
                "Style": 0,
                "Color": {
                    "Red": 0,
                    "Green": 0,
                    "Blue": 0
                }
            },
            "Text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum commodo enim id ex aliquam, vel finibus lectus sollicitudin. Curabitur varius nec erat sit amet lobortis. Suspendisse sollicitudin ut massa a euismod. Etiam auctor augue vel urna commodo, vel posuere ipsum imperdiet. Suspendisse lorem nulla, interdum ut erat molestie, dapibus mattis metus. Donec finibus lorem erat, at egestas neque facilisis id. Vestibulum ac erat maximus, placerat mi vel, maximus elit. Praesent quis dictum ex, quis rutrum elit. Maecenas ullamcorper quam quam, ac ullamcorper sapien condimentum in. Phasellus nec laoreet nulla. Fusce dignissim, magna in cursus porttitor, ligula dui volutpat dui, id pulvinar erat odio sit amet nisi. Vestibulum luctus sit amet lorem consequat mollis. Suspendisse ornare bibendum diam, vel volutpat augue mollis nec. Duis maximus libero et mi scelerisque, ut volutpat tellus ullamcorper."
        },
        {
            "Type": "Whitespace"
        },
        {
            "Type": "Paragraph",
            "Font": {
                "Type": "Helvetica",
                "Size": 12,
                "Style": 0,
                "Color": {
                    "Red": 0,
                    "Green": 0,
                    "Blue": 0
                }
            },
            "Text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum commodo enim id ex aliquam, vel finibus lectus sollicitudin. Curabitur varius nec erat sit amet lobortis. Suspendisse sollicitudin ut massa a euismod. Etiam auctor augue vel urna commodo, vel posuere ipsum imperdiet. Suspendisse lorem nulla, interdum ut erat molestie, dapibus mattis metus. Donec finibus lorem erat, at egestas neque facilisis id. Vestibulum ac erat maximus, placerat mi vel, maximus elit. Praesent quis dictum ex, quis rutrum elit. Maecenas ullamcorper quam quam, ac ullamcorper sapien condimentum in. Phasellus nec laoreet nulla. Fusce dignissim, magna in cursus porttitor, ligula dui volutpat dui, id pulvinar erat odio sit amet nisi. Vestibulum luctus sit amet lorem consequat mollis. Suspendisse ornare bibendum diam, vel volutpat augue mollis nec. Duis maximus libero et mi scelerisque, ut volutpat tellus ullamcorper."
        }
    ]
}'
```


