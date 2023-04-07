FROM docker.io/xdorg1/javacommonbaseimagejdk14
ENV workdir=/root/app/crm-server
ENV LANG C.UTF-8
COPY . ${workdir}
WORKDIR ${workdir}
EXPOSE 9090
CMD ["java","-jar","crm-server-1.0.jar"]