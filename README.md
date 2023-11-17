# PDF Generator
## _spring-boot-pdf-generator_

Application to create a PDF using an API. This can be used as reference for creating PDF documents using the iText java library.

## API Documentation

```yaml
openapi: 3.0.1
info:
  title: PDF Generator
  description: Application to create a PDF using an API
  contact:
    name: Ewantha Udagama
    url: https://github.com/Ewantha
    email: ewanthau@gmail.com
  version: 0.0.2-SNAPSHOT
externalDocs:
  description: itext Website
  url: https://itextpdf.com/
servers:
  - url: http://localhost:8080
    description: Generated server url
paths:
  /document/pdf:
    post:
      tags:
        - document-controller
      summary: Create a PDF Document
      operationId: generateDocument
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/CreateDocumentRequest'
        required: true
      responses:
        "201":
          description: Created
components:
  schemas:
    CreateDocumentRequest:
      required:
        - DocumentName
      type: object
      properties:
        DocumentName:
          type: string
          description: Name of the PDF document
          example: HelloWorld
        Content:
          type: array
          items:
            anyOf:
              - $ref: '#/components/schemas/DocumentContentParagraph'
              - $ref: '#/components/schemas/DocumentContentAnchor'
              - $ref: '#/components/schemas/DocumentContentImage'
              - $ref: '#/components/schemas/DocumentContentTable'
              - $ref: '#/components/schemas/DocumentContentWhitespace'
    DocumentContentParagraph:
      required:
        - Type
      type: object
      properties:
        Type:
          type: string
          description: Type of document element to be created.
          enum:
            - Paragraph
        Font:
          $ref: '#/components/schemas/ElementFont'
        Text:
          type: string
          description: Input text.
          example: Lorem ipsum...
    DocumentContentAnchor:
      required:
        - Type
      type: object
      properties:
        Type:
          type: string
          description: Type of document element to be created.
          enum:
            - Anchor
        Font:
          $ref: '#/components/schemas/ElementFont'
        Text:
          type: string
          description: Input text.
          example: Lorem ipsum...
        Reference:
          type: string
          description: Only for anchor elements and image elements. Set url or image
            source.
          example: www.google.com
    DocumentContentImage:
      required:
        - Type
      type: object
      properties:
        Type:
          type: string
          description: Type of document element to be created.
          enum:
            - Image
        Reference:
          type: string
          description: Only for anchor elements and image elements. Set url or image
            source.
          example: www.google.com
        Scale:
          type: number
          description: Only for image and table elements.
          format: float
          example: 1.2
    DocumentContentTable:
      required:
        - Type
      type: object
      properties:
        Type:
          type: string
          description: Type of document element to be created.
          enum:
            - Table
        Font:
          $ref: '#/components/schemas/ElementFont'
        Scale:
          type: number
          description: Only for image and table elements.
          format: float
          example: 1.2
        Columns:
          type: integer
          description: Only for table elements.
          format: int32
          example: 2
        Data:
          type: array
          description: Only for table elements.
          items:
            type: string
            description: Only for table elements.
        Header:
          type: array
          description: Only for table elements.
          items:
            type: string
            description: Only for table elements.
        HeaderFont:
          $ref: '#/components/schemas/ElementFont'
    DocumentContentWhitespace:
      required:
        - Type
      type: object
      properties:
        Type:
          type: string
          description: Type of document element to be created.
          enum:
            - Whitespace
    DocumentFontColor:
      type: object
      properties:
        Red:
          maximum: 255
          minimum: 0
          type: integer
          format: int32
          default: 0
        Green:
          maximum: 255
          minimum: 0
          type: integer
          format: int32
          default: 0
        Blue:
          maximum: 255
          minimum: 0
          type: integer
          format: int32
          default: 0
    ElementFont:
      type: object
      properties:
        Type:
          type: string
          description: Font type
          default: Helvetica
          enum:
            - Courier
            - Courier-Bold
            - Courier-Oblique
            - Courier-BoldOblique
            - Helvetica
            - Helvetica-Bold
            - Helvetica-Oblique
            - Helvetica-BoldOblique
            - Symbol
            - Times
            - Times-Roman
            - Times-Bold
            - Times-Italic
            - Times-BoldItalic
            - ZapfDingbats
        Size:
          type: integer
          description: Font size
          format: int32
          default: 12
        Style:
          type: integer
          description: "Font style. Normal:0, Bold:1, Italic:2, Underline:4, Strikethrough:8,\
            \ Bold-Italic:3"
          format: int32
          default: 0
        Color:
          $ref: '#/components/schemas/DocumentFontColor'
      description: Only for table elements.

```


[Open API Docs](http://localhost:8080/v3/api-docs)

[Swagger UI](http://localhost:8080/swagger-ui/index.html)

## Getting Started

Documents will be created at ${localPath.pdf}

Sample curl request to create a PDF document.
```curl
curl --location --request POST 'http://localhost:8080/document/pdf' \
--header 'Content-Type: application/json' \
--data-raw '{
    "DocumentName": "Document1",
    "Content": []
}'
```
### Content

- Paragraph
```json
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
```

- Anchor
```json
{
    "Type": "Anchor",
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
    "Text": "Lorem ipsum...",
    "Reference": "www.google.com"
}
```

- Image
```json
{
    "Type": "Image",
    "Reference": "www.google.com",
    "Scale": 1.2
}
```

- Table
```json
{
      "Type": "Table",
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
      "Scale": 1.2,
      "Columns": 2,
      "Data": [
        "string"
      ],
      "Header": [
        "string"
      ],
      "HeaderFont": {
        "Type": "Helvetica",
        "Size": 12,
        "Style": 0,
        "Color": {
          "Red": 0,
          "Green": 0,
          "Blue": 0
        }
      }
    }
```

- Whitespace
```json
{
  "Type": "Whitespace"
}
```

### Example

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


