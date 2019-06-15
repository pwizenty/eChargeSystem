FROM golang:1.10.3
COPY /src/main/pacs/common /go/src/main/pacs/common
WORKDIR /go/src/main/pacs/common
RUN CGO_ENABLED=0 GOOS=linux go build -a -installsuffix cgo -o common .

FROM scratch
COPY --from=0 /go/src/main/pacs/common/common /
ENTRYPOINT ["/common"]
CMD []
EXPOSE 8180
